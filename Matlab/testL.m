%�������

function [testFaceInfo,outSample,imgL]=testL(imgTest)
%%
%���������
%   imgTest:���������ͼ��
%���������
%   testFaceInfo:���������
%   outSample:������б���
%   imgL:����洦��ͼ��
%%
%--------------------------------------------------��������ͼ������-------------------------------
%�������
[~,img,label,imgL]=faceDet(imgTest);
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
sampleL=load('D:\database\data\sampleL.mat');
sampleL=sampleL.sampleL;
autoCL=load('D:\database\data\autoCL.mat');
autoCL=autoCL.autoCL;

Data=[testFaceFeature;sampleL];
[wrong,~,~,~]=KNN_testL(Data,autoCL);

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





