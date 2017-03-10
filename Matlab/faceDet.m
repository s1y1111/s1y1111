
%�������
function [box,imgFace,label,imgF]=faceDet(img)
%%
%���������
%   img:������������
%���������
%   box�����õ�����������
%   imgFace��������ȡ������ͼ��
%   label���������־

%��ʼ��
imgFace=[];
imgF=[];
label=0;

%�Ҷ�ת��
 img=rgb2gray(img);
 
 %%
 %��ȡ����ͼ����Ҫ����
 img=img(80:450,150:500);
 %%
 
%������⣬����matlab�Ӿ���������
faceDetec = vision.CascadeObjectDetector;
box = step(faceDetec, img);
IFaces = insertObjectAnnotation(img, 'rectangle', box, 'Face');
figure, imshow(IFaces), title('Detected faces');
[boxrol,~]=size(box);

for i=1:boxrol
    
    fprintf('%d\n',box(i,3));
    if((80<box(i,3))&&(box(i,3)<180)) %�޶����������С
        box0=box(i,:);
       
        img0=img((box0(1,2)):((box0(1,2)+box0(1,4))),(box0(1,1)):((box0(1,1)+box0(1,3))));
       
        %��������
        imgFace=imresize(img0,[112 92]);
        imgF=imgFace;
        
        %���ɹ�
        label=1;
        %��ʾ����������ڱ���ȷ���ɼ��ɹ�
        figure,imshow(imgFace); 
    end 

    if(isempty(box)&&(~((80<box(i,3))&&(box(i,3)<180))))
        %���ʧ��
        label=0;
        %fprintf('δ��⵽����\n');
    end
end 
end 