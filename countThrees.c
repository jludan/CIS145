/*
 ============================================================================
 Name        : countThrees.c
 Author      : Courtney Brown
 Version     :
 Copyright   : copyright 2014. All Rights Reserved.
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "readInt32BitLE.h"

int main(void) {
	FILE *ptr_threesFile;
	int readValue = 0;
	int threesCount =0;
	//puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */

	ptr_threesFile = fopen("threesData.bin","rb");
	while (!feof(ptr_threesFile)) {
		readValue = readInt32BitLE(ptr_threesFile);
		if (readValue == 3) ++threesCount;
	}

	fclose(ptr_threesFile);

	fprintf(stdout,"%d",threesCount);
	fflush(stdout);
	return EXIT_SUCCESS;
}
