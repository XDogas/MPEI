T = rand(20,20);
for i=1:20
    T(:, i) = T(:, i) / sum(T(:, i));
end

arr = zeros(20,1);
arr(1)=1;
x20 = T^20 * arr;
fprintf("Probabilidade 20 transições: %d\n", x20(20));
x40 = T^40 * arr;
fprintf("Probabilidade 40 transições: %d\n", x40(20));
x100 = T^100 * arr;
fprintf("Probabilidade 100 transições: %d\n", x100(20)); 