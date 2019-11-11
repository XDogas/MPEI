% slide 48 (7-Geração de sequências pseudo-aleatórias)
N=1e6;
n=20;
p=0.3;
X = binomial(n,p,N);
histogram(X)