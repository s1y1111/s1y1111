
function [message,first]=test()

%%�������ܣ�
%   ���ú������Զ����뵱ǰ����ͼ�񣬶�ͼ����м�⣬������ȡ�����ؼ�����Լ���֤��־

%���������
%    ��
%���������
%   message:���Ա�ǩ
%   first���ɹ���־


%���봦��ͼ��
imgL=imread('D:\database\picturesGet\left.jpg');
imgFace=imread('D:\database\picturesGet\center.jpg');
imgR=imread('D:\database\picturesGet\right.jpg');
%}

message={};

[testFaceInfo,~,~,info_label,outSample,imgf]=testFace(imgFace);
if(testFaceInfo==1)%��⵽����
    if(outSample==0)%������������������
        [testFaceInfoL,outSampleL,imgl]=testL(imgL);
        [testFaceInfoR,outSampleR,imgr]=testR(imgR);
        
        if((testFaceInfoL==1)&&(testFaceInfoR==1))   %��������
           if((outSampleL==0)&&(outSampleR==0))
            first=1;
            fprintf('��֤�ɹ�\n');
            info=load('D:\database\data\sampleInfo.mat');
            info=info.sampleInfo;
            message=info{info_label};
            fprintf('%s!\n',message);
           end
           
           if(outSampleL~=0)
             first=0; 
             fprintf('�������ʧ��!\n');   
           end
           if(outSampleR~=0)
              first=0; 
              fprintf('�Ҳ�����ʧ��!\n');
           end 
        end
        
        if((testFaceInfoL~=1)||(testFaceInfoR~=1))
           first=0;
           fprintf('�����¼�����\n');
        end
    end 
    if(outSample==1)%����������������
        first=0; 
        fprintf('����������������!\n');
        imgl=[];
        imgr=[];
    end 
end 
if(testFaceInfo~=1)
    first=0;
    fprintf('δ��⵽��������!\n');
    imgl=[];
    imgr=[];
end  


%д���������
if((~isempty(imgf))&&(~isempty(imgl))&&(~isempty(imgr)))
f=strcat('D:\database\picturesTest\center.jpg');
l=strcat('D:\database\picturesTest\left.jpg');
r=strcat('D:\database\picturesTest\right.jpg');
imwrite(imgf,f);
imwrite(imgl,l);
imwrite(imgr,r);
end 

end