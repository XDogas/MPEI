% silde 39 (7-Gera��o de sequ�ncias pseudo-aleat�rias)
xi = [2 4 6 9];
pX = [0.1 0.2 0.5 0.2];
N = 1e6;

y = fmp(xi,pX,N);
h = histc(y,xi);
bar(xi,h)
xlabel('xi')
ylabel('N�mero de ocorr�ncias')