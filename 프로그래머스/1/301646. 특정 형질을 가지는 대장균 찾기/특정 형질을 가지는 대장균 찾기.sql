select count(*) COUNT
from ECOLI_DATA
where (GENOTYPE & 0b0010 = 0) and (GENOTYPE & 0b0101 > 0)