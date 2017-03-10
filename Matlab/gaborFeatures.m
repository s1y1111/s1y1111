
function featureVector = gaborFeatures(img,gaborArray,d1,d2)

%���ܣ���ȡͼ��GaborС������
%
% �������
%       img         :	����ͼ����� 
%       gaborArray	:	Gabor�˲�����
%       d1          :	ͼ���в������
%       d2          :	ͼ���в������
%               
% �������
%       featureVector	:  ���ͼ����������
%
%
% ��ϵͳ������ȡ������£�
%featureVector = gaborFeatures(img,gaborArray,10,10);
% 
% 
%   �����ο�������£�
%   
% 
% 


if (nargin ~= 4)        %����������
    error('Please use the correct number of input arguments!')
end

if size(img,3) == 3     % ͼ��Ҷ�ת��
    warning('The input RGB image is converted to grayscale!')
    img = rgb2gray(img);
end

img = double(img);


%% ��ͼ�����Gabor�˲�

[u,v] = size(gaborArray);
gaborResult = cell(u,v);
for i = 1:u
    for j = 1:v
        gaborResult{i,j} = imfilter(img, gaborArray{i,j});
    end
end


%%��ȡ��������

featureVector = [];
for i = 1:u
    for j = 1:v
        
        gaborAbs = abs(gaborResult{i,j});
        gaborAbs = downsample(gaborAbs,d1);
        gaborAbs = downsample(gaborAbs.',d2);
        gaborAbs = gaborAbs(:);
        
        
        
        featureVector =  [featureVector; gaborAbs];
        
    end
end
end


