% slide 48 (7-Gera��o de sequ�ncias pseudo-aleat�rias)
N=1e6;
n=20;
p=0.3;
X = binomial(n,p,N);
histogram(X)