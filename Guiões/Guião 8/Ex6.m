% a)
fprintf("6.a)\n")
H = [0.8 0 0.3 0; 0.2 0.9 0.2 0; 0 0.1 0.4 0; 0 0 0.1 1]

% b)
fprintf("6.b)\n")
x0 = [1 0 0 0]';
x1000 = H^1000*x0;
Prob_b = x1000(2)

% c)
fprintf("6.c)\n")
x1 = H*x0
x2 = H^2*x0
x10 = H^10*x0
x100 = H^100*x0

% d)
fprintf("6.d)\n")
Q = H(1:3, 1:3)

% e)
fprintf("6.e)\n")
I = eye(size(Q));
F = inv(I-Q)

% f)
fprintf("6.f)\n")
S = sum(F);
pag1_4 = S(1)
pag2_4 = S(2)
pag3_4 = S(3)

% g)
fprintf("6.g)\n")
tempoAbsorcao = sum(S)

%h)
fprintf("6.h)\n")

H_h=[0.8, 0, 0.3, 0; 0.2, 0.9, 0.2, 0; 0, 0.1, 0.49, 0; 0, 0, 0.01, 1]
Q_h = H_h(1:3,1:3)
aux = eye(size(Q_h)) - Q_h;
F_h = inv(aux)
MediaTempos=sum(F);
fprintf("Tempo atá à absorcao equivale ao numero de passos necessarios para atingir a pagina 4 comecando na pagina 1: %i\n", MediaTempos(1,1));
fprintf("o tempo até à absorcao equivale ao numero de passos necessarios para atingir a pagina 4 comecando na pagina 2: %i\n", MediaTempos(1,2));
fprintf("o tempo ate à absorcao equivale ao numero de passos necessarios para atingir a pagina 4 comecando na pagina 3: %i\n", MediaTempos(1,3));