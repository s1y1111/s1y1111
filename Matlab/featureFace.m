%%�ɼ�������Ϣ
%�������������ɼ�����
%������������

function [resultInfo,featureF,box,imgF]=featureFace(imgFace,i,j,str)
%���������
%   imgFace:��������ͼ��
%   i�����������ڵ�i��ɼ�����
%   j����i�������ĵ�j�βɼ���Ŀǰȡj=5
%   str:������ǩ��Ϣ
%���������
%   resultInfo:������ȡ�ɹ���־
%   featureF����������
%   box:������������
%   imgF��������⴦����ͼ��


%%
%----------------------------------------------------------�ɼ�����---------------------------------------

%�������
[box,img,label,imgF]=faceDet(imgFace);
if(label~=1) %���ʧ��
    %����ʧ�ܱ�־��Ϣ
    resultInfo=0;
    %����������0
    featureF=[];
   %�˳�����
    return 
end 
if(label==1)%���ɹ�
    %���سɹ���־��Ϣ
    resultInfo=1;
    %������ȡ
    featureF=featureVectorsCreat_sample(img);
    
%%
%--------------------------------------------------------------��������------------------------------------------
if((i==1)&&(j==1))
    sample=featureF;
    save('D:\database\data\sample.mat','sample');
else 
   sample_old=load('D:\database\data\sample.mat');
   sample_old=sample_old.sample;
   sample_old(((i-1)*5+j),:)=featureF;
   sample=sample_old;
   save('D:\database\data\sample.mat','sample');
end

end
%%
%--------------------------------------------------------�����������ƶȾ���-----------------------------
%�����ɼ����,
if(j==5)
    sample=load('D:\database\data\sample.mat');
    sample=sample.sample;
    sample=sample(((i-1)*5+1):((i-1)*5+5),:);
    autoC=AutoCorrelation(sample);
    
    
  
     if(i~=1)
        sampleInfo_old=load('D:\database\data\sampleInfo.mat');
        sampleInfo_old=sampleInfo_old.sampleInfo;
        sampleInfo_old{i}=str;
        sampleInfo=sampleInfo_old;
        save('D:\database\data\sampleInfo.mat','sampleInfo');
        %-------------------------------------------------------
        autoC_old=load('D:\database\data\autoC.mat');
        autoC_old=autoC_old.autoC;
        autoC_update=[autoC_old(1:(i-1),:);autoC];
        autoC=autoC_update;
        save('D:\database\data\autoC.mat','autoC');
    end
   if(i==1)
        sampleInfo{i}=str;
        save('D:\database\data\sampleInfo.mat','sampleInfo');
        %--------------------------------------------------
        save('D:\database\data\autoC.mat','autoC');
    end 
end 


end 



