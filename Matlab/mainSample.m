%%
%�����ɼ�����
%i:��ǰ¼��������ڵڼ���
%j:��ǰ¼����˵ĵڼ���ͼ��


function resultInfo=mainSample(i,j,str)
%%
%�����÷�:
%   ���ú�����������ͼ�����������ȡ��������ȡ�����
%���������
%   i:��ǰ�ɼ���������
%   j:��ǰ�����ɼ��Ĵ���
%   str:��ǰ��������
%�������
%   resultInfo��¼��ɹ���־


%����ɼ�ͼ��
imgL=imread('D:\database\picturesGet\left.jpg');
imgFace=imread('D:\database\picturesGet\center.jpg');
imgR=imread('D:\database\picturesGet\right.jpg');
%}

%%
[resultInfof,~,~,imgF]=featureFace(imgFace,i,j,str);
if(resultInfof==1)
    [resultInfol,imgL]=featureMixL(imgL,i,j,str);
        if(resultInfol==1)
        [resultInfor,imgR]=featureMixR(imgR,i,j,str);
        resultInfo=resultInfor;
        else resultInfo=resultInfol;
        end
else resultInfo=resultInfof;    
end     
%д��ɼ�������ͼƬ
%������Ҫ���洦��ͼ����ע�����´���
%---------------------------------------
if(resultInfo==1)
    f=strcat('D:\database\pictures\',num2str(i),'.',num2str(j),'center.jpg');
    l=strcat('D:\database\pictures\',num2str(i),'.',num2str(j),'left.jpg');
    r=strcat('D:\database\pictures\',num2str(i),'.',num2str(j),'right.jpg');
    imwrite(imgF,f);
    imwrite(imgL,l);
    imwrite(imgR,r);
end 
%--------------------------------------------------
end 