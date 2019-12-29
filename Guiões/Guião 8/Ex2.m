% a)
fprintf("2.a)\n")
T = [1-(1/3+1/3) 1/4 0; 1/3 1-(1/4+1/5) 1/2; 1/3 1/5 1/2]
fprintf("Trata-se de uma matriz estocástica, visto que as somas dos valores de cada coluna é igual a 1 e nenhum valor é negativo\n\n")

% b)
fprintf("2.b)\n")

% nTotal = nA + nB + nC
% nB = nC
% nA = 2*(nB + nC)
% logo 90 = 6*nB

nTotal = 90;
nB = 90/6;
nC = nB;
nA = 2*(nB + nC);

x0 = [nA/nTotal nB/nTotal nC/nTotal]'

% c)
fprintf("2.c)\n")
x29 = T^29*x0;
nA_c = round(x29(1)*nTotal)
nB_c = round(x29(2)*nTotal)
nC_c = round(x29(3)*nTotal)

% d)
fprintf("2.d)\n")
nAlunosGrupo = 90/3;
x0_d = [nAlunosGrupo/90 nAlunosGrupo/90 nAlunosGrupo/90]';
x29_d = T^29*x0_d;
nA_d = round(x29(1)*90)
nB_d = round(x29(2)*90)
nC_d = round(x29(3)*90)