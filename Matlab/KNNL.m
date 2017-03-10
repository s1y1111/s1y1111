
function [relustLabel,info,B,distanceMat]= KNNL(inx,data,AutoC,j)
%功能：最近领判别器 
%输入参数：
%   inx：输入测试数据
%   data：样本数据
%   AutoC:样本相似度矩阵
%   j:样本数目
%输出参数：
%   resultLabel:判决结果
%   info:判决标签
%   B：排序后的距离矩阵
%   distanceMat:测试值与样本之间的距离矩阵


[datarow , datacol] = size(data);
diffMat = repmat(inx,[datarow,1]) - data ;%复制测试值，并与样本做差
distanceMat = sqrt(sum(diffMat.^2,2));%求测试值与样本之间的距离，以列向量的方式给出

%求与同一个样本距离的平均值
for i=(1:j/5) %此处样本值有j/5类，每一类共5个样本
    distanceMatAve(i,:)=sum(distanceMat(((i-1)*5+1):((i-1)*5+5),1))/5;
end 

%将距离值按列升序排列，第一列第一行的值小于第二行...类推,B为排序后的距离矩阵，IX为与B中行对应的原位置坐标
[B , IX] = sort(distanceMatAve,'ascend');%最近邻选择
first=(IX(1)-1)*5+1;
last=(IX(1)-1)*5+5;
maxD=max(distanceMat(first:last,:));
maxA=max(AutoC(IX(1),:));
%AutoC是样本相似度矩阵，存储了样本的任意两个特征之间的距离，

%若测试样本的欧氏距离比样本库相似度距离最大值大2，则排除该样本
%%              此处可以更改判决器阈值
%————————————————————————————————————
if(maxD>maxA+2)
    relustLabel=0;
    info=0;
end
if(maxD<=maxA+2)
    relustLabel=1;
    info=IX(1);%最近邻选择
end
end 
