%������

function [testFaceInfo,testFaceFeature,box,info_label,outSample,imgF]=testFace(imgTest)
%%
%���������
%   imgTest:������������ͼ��
%���������
%   testFaceInfo:��������
%   testFaceFeature:��������������
%   box:������������
%   info_label:�������ǩ
%   outSample:�����б���
%   imgF:���洦��ͼ��
%%
%--------------------------------------------------��������ͼ������-------------------------------
%�������
[box,img,label,imgF]=faceDet(imgTest);
if(label~=1) %���ʧ��
    %����ʧ�ܱ�־��Ϣ
    testFaceInfo=0;
    %����������0
    testFaceFeature=[]; 
    info_label=0;
    outSample=0;
end 
if(label==1)%���ɹ�
    %���سɹ���־��Ϣ
    testFaceInfo=1;
    %������ȡ
    testFaceFeature=featureVectorsCreat_sample(img);
%%
%---------------------------------------------------������ȡ�ɹ�����ʼ������-------------------------------------
            %����������Ϣ
sample=load('D:\database\data\sample.mat');
sample=sample.sample;
autoC=load('D:\database\data\autoC.mat');
autoC=autoC.autoC;

Data=[testFaceFeature;sample];
[wrong,info_label,~,~]=KNN_test(Data,autoC);

%������ʧ��
if(wrong==1)
    outSample=1;
end

%������ɹ�
if(wrong~=1)
    outSample=0;
end 
end
end 

