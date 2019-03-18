#include "readInt32BitLE.h"

int readInt32BitLE(FILE *inFile)
{
	int result = 0;
	unsigned char *resultPtr = (unsigned char *) &result;

	if (inFile) {
		int i = 0;
		
		fread(resultPtr,1,4,inFile);
	}
	return result;
}
