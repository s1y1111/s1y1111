%����ע�ͼ�featureMixR
function [resultInfoL,imgL]=featureMixL(imgL,i,j,str)
%imgL:���������ͼ�����

%%
%----------------------------------------------------------�ɼ�����---------------------------------------

%�������
[~,img,label,imgL]=faceDet(imgL);
if(label~=1) %���ʧ��
    %����ʧ�ܱ�־��Ϣ
    resultInfoL=0;
end 
if(label==1)%���ɹ�
    %���سɹ���־��Ϣ
    resultInfoL=1;
    %������ȡ
    featureF=featureVectorsCreat_sample(img);
    
%%
%--------------------------------------------------------------��������------------------------------------------
if((i==1)&&(j==1))
    sampleL=featureF;
    save('D:\database\data\sampleL.mat','sampleL');
else 
    sample_oldL=load('D:\database\data\sampleL.mat');
    sample_oldL=sample_oldL.sampleL;
    sample_oldL((i-1)*5+j,:)=featureF;
    sampleL=sample_oldL;
    save('D:\database\data\sampleL.mat','sampleL');
end


end 
%%
%--------------------------------------------------------�����������ƶȾ���-----------------------------
%�����ɼ����,
if(j==5)
    sampleL=load('D:\database\data\sampleL.mat');
    sampleL=sampleL.sampleL;
    autoCL=AutoCorrelation(sampleL);
    
    %�趨������ǩ���Ҹ���autoC
    if(i~=1)
        sampleInfo_oldL=load('D:\database\data\sampleInfoL.mat');
        sampleInfo_oldL=sampleInfo_oldL.sampleInfoL;
        sampleInfo_oldL{i}=str;
        sampleInfoL=sampleInfo_oldL;
        save('D:\database\data\sampleInfoL.mat','sampleInfoL');
        %-------------------------------------------------------
        autoC_oldL=load('D:\database\data\autoCL.mat');
        autoC_oldL=autoC_oldL.autoCL;
        autoC_updateL=[autoC_oldL(1:(i-1),:);autoCL];
        autoCL=autoC_updateL;
        save('D:\database\data\autoCL.mat','autoCL');
    end 
    if(i==1)
        sampleInfoL{i}=str;
        save('D:\database\data\sampleInfoL.mat','sampleInfoL');
        %--------------------------------------------------
        save('D:\database\data\autoCL.mat','autoCL');
    end 
end 

end 