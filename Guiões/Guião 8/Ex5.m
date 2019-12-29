% a)
fprintf("5.a)\n")
T = [0.7 0.2 0.3; 0.2 0.3 0.3; 0.1 0.5 0.4]

% b)
fprintf("5.b)\n")
x0 = [1 0 0]';
x2 = T^2*x0;
prob_b = x2(3)

% c)
fprintf("5.c) Figura\n")
n = 20;
x = 1:20;
z = zeros(3,20);

for i=1:20
    xi = T^i*x0;
    for j=1:3
        z(j,i) = xi(j);
    end
end

subplot(2,1,1)
plot(x,z)
title("c)")
xlabel("n")
ylabel("Probabilidades")
legend("Sol","Nuvens","Chuva")

% d)
fprintf("5.d) Figura\n")

arr = [];
arr = [arr T(:)];

i=2;
while 1
  Tn = T^i;
  arr = [arr Tn(:)];  
  if max(abs(arr(:,i)-arr(:,i-1))) < 1e-4
    break;
  end  
  i = i+1;
end

subplot(2,1,2)
plot(arr');
title("d)")
xlabel("n")
ylabel("Probabilidades")
legend("Sol","Nuvens", "Chuva")