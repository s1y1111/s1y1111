
function [message,first]=test()

%%函数功能：
%   调用函数，自动读入当前拍摄图像，对图像进行检测，特征提取，返回检测结果以及认证标志

%输入参数：
%    无
%输出参数：
%   message:测试标签
%   first：成功标志


%读入处理图像
imgL=imread('D:\database\picturesGet\left.jpg');
imgFace=imread('D:\database\picturesGet\center.jpg');
imgR=imread('D:\database\picturesGet\right.jpg');
%}

message={};

[testFaceInfo,~,~,info_label,outSample,imgf]=testFace(imgFace);
if(testFaceInfo==1)%检测到人脸
    if(outSample==0)%该人脸存在于样本库
        [testFaceInfoL,outSampleL,imgl]=testL(imgL);
        [testFaceInfoR,outSampleR,imgr]=testR(imgR);
        
        if((testFaceInfoL==1)&&(testFaceInfoR==1))   %侧面人脸
           if((outSampleL==0)&&(outSampleR==0))
            first=1;
            fprintf('认证成功\n');
            info=load('D:\database\data\sampleInfo.mat');
            info=info.sampleInfo;
            message=info{info_label};
            fprintf('%s!\n',message);
           end
           
           if(outSampleL~=0)
             first=0; 
             fprintf('左侧面检测失败!\n');   
           end
           if(outSampleR~=0)
              first=0; 
              fprintf('右侧面检测失败!\n');
           end 
        end
        
        if((testFaceInfoL~=1)||(testFaceInfoR~=1))
           first=0;
           fprintf('请重新检测侧面\n');
        end
    end 
    if(outSample==1)%该人脸不在样本库
        first=0; 
        fprintf('该人脸不在样本库!\n');
        imgl=[];
        imgr=[];
    end 
end 
if(testFaceInfo~=1)
    first=0;
    fprintf('未检测到合适人脸!\n');
    imgl=[];
    imgr=[];
end  


%写入测试人脸
if((~isempty(imgf))&&(~isempty(imgl))&&(~isempty(imgr)))
f=strcat('D:\database\picturesTest\center.jpg');
l=strcat('D:\database\picturesTest\left.jpg');
r=strcat('D:\database\picturesTest\right.jpg');
imwrite(imgf,f);
imwrite(imgl,l);
imwrite(imgr,r);
end 

end