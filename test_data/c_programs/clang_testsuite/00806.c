typedef struct {
        int i;
} something;
typedef const something const_something;
something fail(void);
int
main(int argc, char *argv[])
{
        const_something R = fail();
}
