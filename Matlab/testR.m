%�Ҳ�����

function [testFaceInfo,outSample,imgR]=testR(imgTest)
%%
%���������
%   imgTest:�Ҳ�������ͼ��
%���������
%   testFaceInfo:�Ҳ�������
%   outSample:�Ҳ����б���
%   imgR:�Ҳ��洦��ͼ��
%%
%--------------------------------------------------��������ͼ������-------------------------------
%�������
[~,img,label,imgR]=faceDet(imgTest);
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
sampleR=load('D:\database\data\sampleR.mat');
sampleR=sampleR.sampleR;
autoCR=load('D:\database\data\autoCR.mat');
autoCR=autoCR.autoCR;

Data=[testFaceFeature;sampleR];
[wrong,~,~,~]=KNN_testR(Data,autoCR);

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





