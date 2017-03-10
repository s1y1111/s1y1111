%右侧面检测

function [testFaceInfo,outSample,imgR]=testR(imgTest)
%%
%输入参数：
%   imgTest:右侧面待检测图像
%输出参数：
%   testFaceInfo:右侧面检测结果
%   outSample:右侧面判别结果
%   imgR:右侧面处理图像
%%
%--------------------------------------------------计算待检测图像特征-------------------------------
%人脸检测
[~,img,label,imgR]=faceDet(imgTest);
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
sampleR=load('D:\database\data\sampleR.mat');
sampleR=sampleR.sampleR;
autoCR=load('D:\database\data\autoCR.mat');
autoCR=autoCR.autoCR;

Data=[testFaceFeature;sampleR];
[wrong,~,~,~]=KNN_testR(Data,autoCR);

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





