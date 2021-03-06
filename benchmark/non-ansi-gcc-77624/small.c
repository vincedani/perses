typedef
long
unsigned
int
size_t
;
typedef
int
wchar_t
;
typedef
struct
{
int
quot
;
int
rem
;
}
div_t
;
typedef
struct
{
long
int
quot
;
long
int
rem
;
}
ldiv_t
;
__extension__
typedef
struct
{
long
long
int
quot
;
long
long
int
rem
;
}
lldiv_t
;
extern
size_t
__ctype_get_mb_cur_max
(
void
)
__attribute__
(
(
__nothrow__
)
)
;
extern
double
atof
(
const
char
*
__nptr
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__pure__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
int
atoi
(
const
char
*
__nptr
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__pure__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
long
int
atol
(
const
char
*
__nptr
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__pure__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
__extension__
extern
long
long
int
atoll
(
const
char
*
__nptr
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__pure__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
double
strtod
(
const
char
*
__restrict
__nptr
,
char
*
*
__restrict
__endptr
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
float
strtof
(
const
char
*
__restrict
__nptr
,
char
*
*
__restrict
__endptr
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
long
double
strtold
(
const
char
*
__restrict
__nptr
,
char
*
*
__restrict
__endptr
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
long
int
strtol
(
const
char
*
__restrict
__nptr
,
char
*
*
__restrict
__endptr
,
int
__base
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
unsigned
long
int
strtoul
(
const
char
*
__restrict
__nptr
,
char
*
*
__restrict
__endptr
,
int
__base
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
__extension__
extern
long
long
int
strtoll
(
const
char
*
__restrict
__nptr
,
char
*
*
__restrict
__endptr
,
int
__base
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
__extension__
extern
unsigned
long
long
int
strtoull
(
const
char
*
__restrict
__nptr
,
char
*
*
__restrict
__endptr
,
int
__base
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
int
rand
(
void
)
__attribute__
(
(
__nothrow__
)
)
;
extern
void
srand
(
unsigned
int
__seed
)
__attribute__
(
(
__nothrow__
)
)
;
extern
void
*
malloc
(
size_t
__size
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__malloc__
)
)
;
extern
void
*
calloc
(
size_t
__nmemb
,
size_t
__size
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__malloc__
)
)
;
extern
void
*
realloc
(
void
*
__ptr
,
size_t
__size
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__warn_unused_result__
)
)
;
extern
void
free
(
void
*
__ptr
)
__attribute__
(
(
__nothrow__
)
)
;
extern
void
*
aligned_alloc
(
size_t
__alignment
,
size_t
__size
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__malloc__
)
)
;
extern
void
abort
(
void
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__noreturn__
)
)
;
extern
int
atexit
(
void
(
*
__func
)
(
void
)
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
int
at_quick_exit
(
void
(
*
__func
)
(
void
)
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
void
exit
(
int
__status
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__noreturn__
)
)
;
extern
void
quick_exit
(
int
__status
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__noreturn__
)
)
;
extern
void
_Exit
(
int
__status
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__noreturn__
)
)
;
extern
char
*
getenv
(
const
char
*
__name
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__nonnull__
(
1
)
)
)
;
extern
int
system
(
const
char
*
__command
)
;
typedef
int
(
*
__compar_fn_t
)
(
const
void
*
,
const
void
*
)
;
extern
void
*
bsearch
(
const
void
*
__key
,
const
void
*
__base
,
size_t
__nmemb
,
size_t
__size
,
__compar_fn_t
__compar
)
__attribute__
(
(
__nonnull__
(
1
,
2
,
5
)
)
)
;
extern
void
qsort
(
void
*
__base
,
size_t
__nmemb
,
size_t
__size
,
__compar_fn_t
__compar
)
__attribute__
(
(
__nonnull__
(
1
,
4
)
)
)
;
extern
int
abs
(
int
__x
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__const__
)
)
;
extern
long
int
labs
(
long
int
__x
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__const__
)
)
;
__extension__
extern
long
long
int
llabs
(
long
long
int
__x
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__const__
)
)
;
extern
div_t
div
(
int
__numer
,
int
__denom
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__const__
)
)
;
extern
ldiv_t
ldiv
(
long
int
__numer
,
long
int
__denom
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__const__
)
)
;
__extension__
extern
lldiv_t
lldiv
(
long
long
int
__numer
,
long
long
int
__denom
)
__attribute__
(
(
__nothrow__
)
)
__attribute__
(
(
__const__
)
)
;
extern
int
mblen
(
const
char
*
__s
,
size_t
__n
)
__attribute__
(
(
__nothrow__
)
)
;
extern
int
mbtowc
(
wchar_t
*
__restrict
__pwc
,
const
char
*
__restrict
__s
,
size_t
__n
)
__attribute__
(
(
__nothrow__
)
)
;
extern
int
wctomb
(
char
*
__s
,
wchar_t
__wchar
)
__attribute__
(
(
__nothrow__
)
)
;
extern
size_t
mbstowcs
(
wchar_t
*
__restrict
__pwcs
,
const
char
*
__restrict
__s
,
size_t
__n
)
__attribute__
(
(
__nothrow__
)
)
;
extern
size_t
wcstombs
(
char
*
__restrict
__s
,
const
wchar_t
*
__restrict
__pwcs
,
size_t
__n
)
__attribute__
(
(
__nothrow__
)
)
;
extern
void
abort
(
void
)
;
short
as
,
bs
,
cs
,
ds
;
char
ac
,
bc
,
cc
;
int
main
(
void
)
{
ac
=
__atomic_exchange_n
(
&
bc
,
cc
,
0
)
;
if
(
bc
!=
1
)
abort
(
)
;
as
=
__atomic_load_n
(
&
bs
,
5
)
;
if
(
bs
!=
1
)
abort
(
)
;
__atomic_store_n
(
&
ac
,
bc
,
0
)
;
if
(
ac
!=
1
)
abort
(
)
;
__atomic_compare_exchange_n
(
&
as
,
&
bs
,
cs
,
0
,
5
,
2
)
;
if
(
as
!=
1
)
abort
(
)
;
ac
=
__atomic_fetch_add
(
&
cc
,
15
,
5
)
;
if
(
cc
!=
1
)
abort
(
)
;
as
=
__atomic_add_fetch
(
&
cs
,
10
,
0
)
;
if
(
cs
!=
1
)
abort
(
)
;
ac
=
0x3C
;
bc
=
__atomic_nand_fetch
(
&
ac
,
0x0f
,
0
)
;
if
(
bc
!=
ac
)
abort
(
)
;
if
(
!
__atomic_is_lock_free
(
2
,
ds
)
)
abort
(
)
;
if
(
ds
!=
1
)
abort
(
)
;
return
0
;
}
