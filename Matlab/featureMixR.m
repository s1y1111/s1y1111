

function [resultInfoR,imgR]=featureMixR(imgR,i,j,str)
%���ܣ�
%   �ɼ�������Ϣ
%   �������������ɼ�����
%   ������������
%���������
%   imgFace:�����Ҳ���ͼ��
%   i�����������ڵ�i��ɼ�����
%   j����i�������ĵ�j�βɼ���Ŀǰȡj=5
%   str:������ǩ��Ϣ
%���������
%   imgR:����ͼ��
%   resultInfoR:�ɹ���ǩ

%%
%----------------------------------------------------------�ɼ�����---------------------------------------

%�������
[~,img,label,imgR]=faceDet(imgR);
if(label~=1) %���ʧ��
    %����ʧ�ܱ�־��Ϣ
    resultInfoR=0;
   
   %�˳�����
    return 
end 
if(label==1)%���ɹ�
    %���سɹ���־��Ϣ
    resultInfoR=1;
    %������ȡ
    featureF=featureVectorsCreat_sample(img);
    
%%
%--------------------------------------------------------------��������------------------------------------------
if((i==1)&&(j==1))
    sampleR=featureF;
    save('D:\database\data\sampleR.mat','sampleR');
else
    sample_oldR=load('D:\database\data\sampleR.mat');
    sample_oldR=sample_oldR.sampleR;
    sample_oldR((i-1)*5+j,:)=featureF;
    sampleR=sample_oldR;
    save('D:\database\data\sampleR.mat','sampleR');
end  

end 
%%
%--------------------------------------------------------�����������ƶȾ���-----------------------------
%�����ɼ����,
if(j==5)
    sampleR=load('D:\database\data\sampleR.mat');
    sampleR=sampleR.sampleR;
    autoCR=AutoCorrelation(sampleR);
    
    %�趨������ǩ���Ҹ���autoC
    if(i~=1)
        sampleInfo_oldR=load('D:\database\data\sampleInfoR.mat');
        sampleInfo_oldR=sampleInfo_oldR.sampleInfoR;
        sampleInfo_oldR{i}=str;
        sampleInfoR=sampleInfo_oldR;
        save('D:\database\data\sampleInfoR.mat','sampleInfoR');
        %-------------------------------------------------------
        autoC_oldR=load('D:\database\data\autoCR.mat');
        autoC_oldR=autoC_oldR.autoCR;
        autoC_updateR=[autoC_oldR(1:(i-1),:);autoCR];
        autoCR=autoC_updateR;
        save('D:\database\data\autoCR.mat','autoCR');
    end 
    if(i==1)
        sampleInfoR{i}=str;
        save('D:\database\data\sampleInfoR.mat','sampleInfoR');
        %--------------------------------------------------
        save('D:\database\data\autoCR.mat','autoCR');
    end 
end 


end 



