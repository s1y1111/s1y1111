function [wrong,info_label,B,distanceMat]=KNN_testL(Data,AutoC)
%���ܣ��б������
%���������
%   Data��������󣬵�һ��Ϊ������������������Ϊ��������
%   AutoC:�����������ƶȾ���
%���������
%   wrong:�о����
%   info_label:�о���ǩ
%   B���о���ľ����������
%   distanceMat:�о�����

[i,~]=size(Data);%�ж�������С
i=i-1;%ʵ������������С

dataMat = Data(:,1:4800);
len = size(dataMat,1);
%��һ������
maxV = max(dataMat);
minV = min(dataMat);
range = maxV-minV;
newdataMat = (dataMat-repmat(minV,[len,1]))./(repmat(range,[len,1]));
% ���ԣ�����һ����Ϊ����ֵ��������Ϊ����ֵ
 [classifyresult,info_label,B,distanceMat]= KNNL(newdataMat(1,:),newdataMat(2:len,:),AutoC,i);
 if(classifyresult==0)
     wrong=1;%����������������������
 end 
 if(classifyresult~=0) %��������������������
    wrong=0;
 end 
end 