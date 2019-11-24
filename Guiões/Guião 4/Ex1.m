% slide 11 (7-Gera��o de sequ�ncias pseudo-aleat�rias)
X0 = 3;
a = 3;
c = 3;
m = 5;
N = 1e5;

%% a)
U = lcg(X0,a,c,m,N);
Y = unique(U);  % quantidade de n�meros diferentes

subplot(3,1,1)
histogram(Y)
title('Ex 1.a)')
xlabel('N�meros')
ylabel('Quantidade')
%axis([0 0 0 0]);

%% b)
Ub = U / m;
Yb = unique(Ub);

subplot(3,1,2)
histogram(Yb)
title('Ex 1.b)')
xlabel('N�meros')
ylabel('Quantidade')
%axis([0 0 0 0]);

%% c)
% par�metros MATLAB: a = 7^5, c = 0 e m = (2^31)-1
X0c = 1;
ac = 7^5;
cc = 0;
mc = (2^31)-1;
Nc = 1e5;

Uc = lcg(X0c,ac,cc,mc,Nc);
Yc = unique(Uc);  % quantidade de n�meros diferentes

subplot(3,1,3)
histogram(Yc)
title('Ex 1.c)')
xlabel('N�meros')
ylabel('Quantidade')
%axis([0 0 0 0]);

