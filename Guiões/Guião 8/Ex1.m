% a)
fprintf("1.a)\n")
T = [0.7 0.8; 0.3 0.2];

x0_a = [1 0]';
x2_a = T^2*x0_a;
prob_a = x2_a(1)

% b)
fprintf("1.b)\n")
x0_b = [0 1]';
x2_b = T^2*x0_b;
prob_b = x2_b(1)

% c)
fprintf("1.c)\n")
numAulas = 15*2; % 2 aulas por semana
numTransicoes = numAulas - 1;

x0_c = [1 0]';
x_numTransicoes_c = T^numTransicoes*x0_c;
prob_c = x_numTransicoes_c(1)

% d)
fprintf("1.d) Gráfico\n")
x0_d = [0.85 0.15]';

prob_d = zeros(1,30);
prob_d(1) = x0_d(2);

for i=2:30
    xi_d = T^i*x0_d;
    prob_d(i) = xi_d(2);
end

plot(prob_d)
