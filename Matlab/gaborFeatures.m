
function featureVector = gaborFeatures(img,gaborArray,d1,d2)

%功能：提取图像Gabor小波特征
%
% 输入参数
%       img         :	输入图像矩阵 
%       gaborArray	:	Gabor滤波器组
%       d1          :	图像行采样间隔
%       d2          :	图像列采样间隔
%               
% 输出参数
%       featureVector	:  输出图像特征向量
%
%
% 本系统特征提取设计如下：
%featureVector = gaborFeatures(img,gaborArray,10,10);
% 
% 
%   函数参考设计如下：
%   
% 
% 


if (nargin ~= 4)        %检查输入参数
    error('Please use the correct number of input arguments!')
end

if size(img,3) == 3     % 图像灰度转换
    warning('The input RGB image is converted to grayscale!')
    img = rgb2gray(img);
end

img = double(img);


%% 对图像进行Gabor滤波

[u,v] = size(gaborArray);
gaborResult = cell(u,v);
for i = 1:u
    for j = 1:v
        gaborResult{i,j} = imfilter(img, gaborArray{i,j});
    end
end


%%提取特征向量

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


