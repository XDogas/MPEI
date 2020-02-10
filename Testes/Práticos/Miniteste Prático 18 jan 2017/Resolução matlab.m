%% Ex1
% a)
fprintf("1.a)\n")
T = [0.9 0.5 0.5; 0.09 0.4 0.4; 0.01 0.1 0.1]
v = [0 0 1]'

% b)
fprintf("1.b)\n")
v3 = T^3*v;
prob_0erros = v3(1)
prob_1erro = v3(2)
prob_2ouMaisErros = v3(3)
fprintf("Pacote recebido sem erros: %d\n", v3(1));
fprintf("Pacote recebido com 1 erro: %d\n", v3(2));
fprintf("Pacote recebido com 2 ou mais erros: %d\n", v3(3));

%% Ex2
%a)
fprintf("2.a)\n")
H = [0 1/2 1/3 1/4 0; 1/2 0 0 1/4 1/2; 1/2 1/2 1/3 1/4 0; 0 0 0 0 1/2; 0 0 1/3 1/4 0];
B = 0.8;
N = 5;
%M(1:N,1:N) = 1/N;
%A = B*H + (1-B)*M
A = B*H + (1-B)*ones(N)/N

% b)
fprintf("2.b)\n")
x0 = ones(N,1)/N;
x10 = H^10*x0
prC = x10(1)
prD = x10(2)
prE = x10(3)
prF = x10(4)
prG = x10(5)

%% Ex3
% a)
fprintf("3.a)\n")
T = [0.7 0.2 0 0 0 0; 0.2 0 0.3 0 0 0; 0 0.6 0.3 0 0 0; 0.1 0.2 0.3 0.1 0 0; 0 0 0.1 0.5 1 0; 0 0 0 0.4 0 1]

%b)
fprintf("3.b)\n")
x0 = [1 0 0 0 0 0]';
x9 = T^9*x0;
prob_10serc = x9(3)
x14 = T^14*x0;
prob_15serd = x14(4)

% c)
fprintf("3.c)\n")
Q = T(1:4,1:4);
I = eye(size(Q));
F = inv(I-Q);
S = sum(F);
media = S(3)

%% Exemplo
N = 20;
[U,L] = surfer('http://www.ua.pt',N);

imagesc(L);
colormap(gray);

H=full(L);
c=sum(full(L)); % número de ligações(d)
H=H./repmat(c,N,1)
p=0.85
A=p*H+(1-p)* ones(N)/N % matriz da Google
A(isnan(A))=1/N % resolver dead ends

x0=ones(N,1)/N;
iter=1;
x=x0;
epsilon=1e-3;
while 1
    fprintf(1,'iteração %d\n',iter);
    xold=x
    x=A*x;
    if max(abs(x-xold))<epsilon break ; end
    iter=iter+1;
end
x

[xs idx]=sort(x,'descend');
for p=1:N
    fprintf(1,'PageRank=%.3f: %s\n',x(idx(p)), U{idx(p)});
end

