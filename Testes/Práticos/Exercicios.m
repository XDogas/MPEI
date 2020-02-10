%% Miniteste Prático 2015/2016
% Ex2
% a)
fprintf("2.a)\n")
H = [0   0   1/2 0   1/2 1/5;
     1/4 1/3 1/2 1/2 1/2 1/5;
     1/4 0   0   0   0   1/5;
     1/4 1/3 0   0   0   1/5;
     1/4 0   0   1/2 0   1/5;
     0   1/3 0   0   0   0];
 
 x0 = ones(6,1)/6;
 x3 = H^3*x0;
 prA = x3(1)
 prB = x3(2)
 prC = x3(3)
 prD = x3(4)
 prE = x3(5)
 prF = x3(6)
 
 % b)
 fprintf("2.b)\n")
 x_atual = x0;
 N = 100;
 resultado = zeros(length(H),N);
 for k=1:100
     x_atual = H*x_atual;
     resultado(:,k) = x_atual;
 end
 figure;
 stem(1:N,resultado)
 
 %c)
 fprintf("2.c)\n")
 [max_pr, pag_max_pr] = max(x_atual);
 
%% Miniteste Prático 2018/2019
% Ex2
% a)
fprintf("2.a)\n")
T = [0.7 0.1 0	 0	 0	 0;
     0.2 0	 0	 0.3 0	 0;
     0.1 0.3 0.1 0.4 0	 0;
     0   0.6 0   0.1 0   0;
     0   0   0.4 0.2 1   0;
     0   0   0.5 0   0   1]
 
 v = [0 1/2 0 1/2 0 0]'
 
 %b)
 fprintf("2.b)\n")
 Q = T(1:4,1:4);
 I = eye(size(Q));
 F = inv(I-Q);
 S = sum(F);
 media = S(1)
 
 %c)
  fprintf("2.c)\n")
  v0 = [1 0 0 0 0 0]';
  v5 = T^5*v0;
  prob_Iraque_EUA = v5(5)
  v0 = [0 0 1 0 0 0]';
  v50 = T^50*v0;
  prob_Brasil_Israel = v50(6)