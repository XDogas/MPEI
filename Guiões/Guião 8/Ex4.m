% a)
fprintf("4.a)\n")
p = 0.4;
q = 0.6;
T = [p^2 0 0 q^2; (1-p)^2 0 0 q*(1-q); p*(1-p) 0 0 q*(1-q); p*(1-p) 1 1 (1-q)^2]

% b)
fprintf("4.b)\n")
x0 = [1 0 0 0]';
x10 = T^10*x0;
prob_B = x10(1)
prob_B = x10(2)
prob_C = x10(3)
prob_D = x10(4)