function sample=featureVectorsCreat_sample(img)
   
    %����������˹������ǿͼ��
    w=fspecial('laplacian',0);%�����ռ�ģ��
    img=double(img);
    img1=imfilter(img,w,'replicate');%imgΪԭʼ����ͼ��img1Ϊ������˹ͼ��
    img=img-img1;%��ԭʼͼ����ǰȥ������˹ͼ���Իָ�ʧȥ�ĻҶȲ��,imgΪ������˹��ǿ���ͼ��

     %��GaborС��������������
     gaborArray = gaborFilterBank(5,8,40,40);  % ����Gabor�˲�����
     featureVector = gaborFeatures(img,gaborArray,10,10); 
     sample=featureVector';
end
