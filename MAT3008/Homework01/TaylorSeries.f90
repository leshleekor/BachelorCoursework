implicit real*8(a-h, o-z)
	real*8 mycos

	s = mycos(0.5d0, 1.d-7)

	write(*, *) s, cos(0.5)

	stop
end

real*8 function mycos(x, eps)
	implicit real*8(a-h, o-z)

	sum = 0.
	term = 1.
	xsq = x*x
	kflag = -1
	k = 1

	do while (abs(term) > eps)
	  kflag = -kflag
	  sum = sum + kflag*term
	  term = term*xsq/float(k)/float(k+1)
	  k = k + 2
        enddo

	mycos = sum

	return
end
