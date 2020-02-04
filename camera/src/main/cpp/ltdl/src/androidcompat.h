/* androidcompat.h -- android compatibility header file
 * Copyright (C) 2010 Konstantin Sobolev
 * konstantin.sobolev@gmail.com
 */

#ifndef ANDROIDCOMPAT_H
#define ANDROIDCOMPAT_H 1

# ifndef __error_t_defined
typedef int error_t;
#  define __error_t_defined     1
# endif

#include <asm-generic/errno-base.h>

#endif
