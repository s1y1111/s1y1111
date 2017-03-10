

function [resultInfoR,imgR]=featureMixR(imgR,i,j,str)
%功能：
%   采集样本信息
%   建立正面样本采集函数
%   更新样本特征
%输入参数：
%   imgFace:输入右侧面图像
%   i：该样本属于第i类采集样本
%   j：第i类样本的地j次采集，目前取j=5
%   str:样本标签信息
%输出参数：
%   imgR:处理图像
%   resultInfoR:成功标签

%%
%----------------------------------------------------------采集样本---------------------------------------

%人脸检测
[~,img,label,imgR]=faceDet(imgR);
if(label~=1) %检测失败
    %返回失败标志信息
    resultInfoR=0;
   
   %退出函数
    return 
end 
if(label==1)%检测成功
    %返回成功标志信息
    resultInfoR=1;
    %特征提取
    featureF=featureVectorsCreat_sample(img);
    
%%
%--------------------------------------------------------------更新样本------------------------------------------
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
%--------------------------------------------------------计算样本相似度矩阵-----------------------------
%样本采集完毕,
if(j==5)
    sampleR=load('D:\database\data\sampleR.mat');
    sampleR=sampleR.sampleR;
    autoCR=AutoCorrelation(sampleR);
    
    %设定样本标签并且更新autoC
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



