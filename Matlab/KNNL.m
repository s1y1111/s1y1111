
function [relustLabel,info,B,distanceMat]= KNNL(inx,data,AutoC,j)
%���ܣ�������б��� 
%���������
%   inx�������������
%   data����������
%   AutoC:�������ƶȾ���
%   j:������Ŀ
%���������
%   resultLabel:�о����
%   info:�о���ǩ
%   B�������ľ������
%   distanceMat:����ֵ������֮��ľ������


[datarow , datacol] = size(data);
diffMat = repmat(inx,[datarow,1]) - data ;%���Ʋ���ֵ��������������
distanceMat = sqrt(sum(diffMat.^2,2));%�����ֵ������֮��ľ��룬���������ķ�ʽ����

%����ͬһ�����������ƽ��ֵ
for i=(1:j/5) %�˴�����ֵ��j/5�࣬ÿһ�๲5������
    distanceMatAve(i,:)=sum(distanceMat(((i-1)*5+1):((i-1)*5+5),1))/5;
end 

%������ֵ�����������У���һ�е�һ�е�ֵС�ڵڶ���...����,BΪ�����ľ������IXΪ��B���ж�Ӧ��ԭλ������
[B , IX] = sort(distanceMatAve,'ascend');%�����ѡ��
first=(IX(1)-1)*5+1;
last=(IX(1)-1)*5+5;
maxD=max(distanceMat(first:last,:));
maxA=max(AutoC(IX(1),:));
%AutoC���������ƶȾ��󣬴洢��������������������֮��ľ��룬

%������������ŷ�Ͼ�������������ƶȾ������ֵ��2�����ų�������
%%              �˴����Ը����о�����ֵ
%������������������������������������������������������������������������
if(maxD>maxA+2)
    relustLabel=0;
    info=0;
end
if(maxD<=maxA+2)
    relustLabel=1;
    info=IX(1);%�����ѡ��
end
end 
