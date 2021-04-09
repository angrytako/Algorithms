CFLAGS 		= -g -O1 -Wall -Wextra -Wpedantic -Wconversion
COMMON_DEPS 	= src/*.h Makefile

all: bin/client

build/%.o: src/%.c $(COMMON_DEPS)
	gcc $(CFLAGS) -c $< -o $@

bin/client: build/parser.o build/validation.o build/sort.o build/client.o $(COMMON_DEPS)
	gcc -o bin/client build/parser.o build/validation.o build/sort.o build/client.o


clean:
	$(RM) build/*
	$(RM) bin/*
