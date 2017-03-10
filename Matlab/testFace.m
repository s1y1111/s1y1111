%正面检测

function [testFaceInfo,testFaceFeature,box,info_label,outSample,imgF]=testFace(imgTest)
%%
%输入参数：
%   imgTest:输入正面待检测图像
%输出参数：
%   testFaceInfo:正面检测结果
%   testFaceFeature:正面检测特征向量
%   box:正面脸部区域
%   info_label:正面检测标签
%   outSample:正面判别结果
%   imgF:正面处理图像
%%
%--------------------------------------------------计算待检测图像特征-------------------------------
%人脸检测
[box,img,label,imgF]=faceDet(imgTest);
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
sample=load('D:\database\data\sample.mat');
sample=sample.sample;
autoC=load('D:\database\data\autoC.mat');
autoC=autoC.autoC;

Data=[testFaceFeature;sample];
[wrong,info_label,~,~]=KNN_test(Data,autoC);

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

