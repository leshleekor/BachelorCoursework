!
! Newton’s method for 2 variables
!
implicit real*8(a-h, o-z)
! gy(x,y) = x
f(x,y) = x*x + 4*y*y - 16
g(x,y) = x*y*y - 4
fx(x,y) = 2.*x
fy(x,y) = 8.*y
gx(x,y) = y*y
gy(x,y) = 2.*x*y
write(*, *) ' ** Enter eps **'
read(*, *) eps
x0 = 1.0
y0 = 1.5
k = 0
100 continue
k = k + 1
a11 = fx(x0,y0)
a12 = fy(x0,y0)
a21 = gx(x0,y0)
a22 = gy(x0,y0)
det = a11*a22 - a12*a21
vx = f(x0,y0)
vy = g(x0, y0)
delx = (a22*vx -a12*vy)/det
dely = (-a21*vx +a11*vy)/det
x = x0 - delx
y = y0 - dely
print*,' x, y = ', k, x, y,' value = ', f(x,y), g(x,y)
xn2 = x**2 + y**2
err = sqrt((delx**2 + dely**2)/xn2)
x0 = x
y0 = y
if(err .gt. eps) goto 100
write(*,*) '** Function value **'
write(*, *) f(x, y), g(x, y)
stop
end