real*8 function A1norm(A, M, N)
	dimension A(M, *)

	rmax = -1.
	do j = 1, N
	  sum = 0.
	  do i = 1, M
	    sum = sum + abs(A(i,j))
	  enddo
	  if(sum > rmax) rmax = sum
      enddo

	A1norm = rmax

	return
end

