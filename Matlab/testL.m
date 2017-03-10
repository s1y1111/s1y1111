%左侧面检测

function [testFaceInfo,outSample,imgL]=testL(imgTest)
%%
%输入参数：
%   imgTest:左侧面待检测图像
%输出参数：
%   testFaceInfo:左侧面检测结果
%   outSample:左侧面判别结果
%   imgL:左侧面处理图像
%%
%--------------------------------------------------计算待检测图像特征-------------------------------
%人脸检测
[~,img,label,imgL]=faceDet(imgTest);
if(label~=1) %检测失败
    %返回失败标志信息
    testFaceInfo=0;
    %特征矩阵置0
    testFaceFeature=[]; 
    info_label=0;
    outSample=0;
end 
if(label==1)%检测成功
    %返回成功标志信息
    testFaceInfo=1;
    %特征提取
    testFaceFeature=featureVectorsCreat_sample(img);
%%
%---------------------------------------------------特征提取成功，开始正面检测-------------------------------------
            %加载样本信息
sampleL=load('D:\database\data\sampleL.mat');
sampleL=sampleL.sampleL;
autoCL=load('D:\database\data\autoCL.mat');
autoCL=autoCL.autoCL;

Data=[testFaceFeature;sampleL];
[wrong,~,~,~]=KNN_testL(Data,autoCL);

%正面检测失败
if(wrong==1)
    outSample=1;
end

%正面检测成功
if(wrong~=1)
    outSample=0;
end 
end
end 





