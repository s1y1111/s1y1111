function [wrong,info_label,B,distanceMat]=KNN_testL(Data,AutoC)
%功能：判别器设计
%输入参数：
%   Data：输入矩阵，第一行为待测试特征，其余行为样本特征
%   AutoC:样本特征相似度矩阵
%输出参数：
%   wrong:判决结果
%   info_label:判决标签
%   B：判决后的距离排序矩阵
%   distanceMat:判决距离

[i,~]=size(Data);%判断样本大小
i=i-1;%实际样本样本大小

dataMat = Data(:,1:4800);
len = size(dataMat,1);
%归一化处理
maxV = max(dataMat);
minV = min(dataMat);
range = maxV-minV;
newdataMat = (dataMat-repmat(minV,[len,1]))./(repmat(range,[len,1]));
% 测试，将第一行作为测试值，其余作为样本值
 [classifyresult,info_label,B,distanceMat]= KNNL(newdataMat(1,:),newdataMat(2:len,:),AutoC,i);
 if(classifyresult==0)
     wrong=1;%待测试样本不在样本库中
 end 
 if(classifyresult~=0) %待测样本存在于样本库
    wrong=0;
 end 
end 