function sample=featureVectorsCreat_sample(img)
   
    %采用拉普拉斯算子增强图像
    w=fspecial('laplacian',0);%建立空间模板
    img=double(img);
    img1=imfilter(img,w,'replicate');%img为原始输入图像，img1为拉普拉斯图像
    img=img-img1;%从原始图像中前去拉普拉斯图像以恢复失去的灰度层次,img为拉普拉斯增强后的图像

     %用Gabor小波产生特征向量
     gaborArray = gaborFilterBank(5,8,40,40);  % 建立Gabor滤波器组
     featureVector = gaborFeatures(img,gaborArray,10,10); 
     sample=featureVector';
end
