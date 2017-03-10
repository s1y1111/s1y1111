
%人脸检测
function [box,imgFace,label,imgF]=faceDet(img)
%%
%输入参数：
%   img:输入待检测人脸
%输出参数：
%   box：检测得到的人脸区域
%   imgFace：检测后提取的人脸图像
%   label：检测结果标志

%初始化
imgFace=[];
imgF=[];
label=0;

%灰度转换
 img=rgb2gray(img);
 
 %%
 %截取输入图像主要部分
 img=img(80:450,150:500);
 %%
 
%人脸检测，调用matlab视觉处理工具箱
faceDetec = vision.CascadeObjectDetector;
box = step(faceDetec, img);
IFaces = insertObjectAnnotation(img, 'rectangle', box, 'Face');
figure, imshow(IFaces), title('Detected faces');
[boxrol,~]=size(box);

for i=1:boxrol
    
    fprintf('%d\n',box(i,3));
    if((80<box(i,3))&&(box(i,3)<180)) %限定人脸区域大小
        box0=box(i,:);
       
        img0=img((box0(1,2)):((box0(1,2)+box0(1,4))),(box0(1,1)):((box0(1,1)+box0(1,3))));
       
        %处理检测结果
        imgFace=imresize(img0,[112 92]);
        imgF=imgFace;
        
        %检测成功
        label=1;
        %显示检测结果，用于本人确定采集成功
        figure,imshow(imgFace); 
    end 

    if(isempty(box)&&(~((80<box(i,3))&&(box(i,3)<180))))
        %检测失败
        label=0;
        %fprintf('未检测到人脸\n');
    end
end 
end 