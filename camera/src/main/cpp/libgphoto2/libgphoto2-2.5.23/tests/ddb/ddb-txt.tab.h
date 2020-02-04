/* A Bison parser, made by GNU Bison 3.3.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015, 2018-2019 Free Software Foundation,
   Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* Undocumented macros, especially those whose name start with YY_,
   are private implementation details.  Do not rely on them.  */

#ifndef YY_YY_DDB_TXT_TAB_H_INCLUDED
# define YY_YY_DDB_TXT_TAB_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    TOK_SEP = 258,
    TOK_COMMA = 259,
    TOK_WHITESPACE = 260,
    TOK_NEWLINE = 261,
    TOK_NUMBER = 262,
    TOK_STRING = 263,
    TOK_INTERFACE = 264,
    TOK_DRIVER = 265,
    TOK_DEVICE = 266,
    TOK_BEGIN = 267,
    TOK_END = 268,
    TOK_SERIAL = 269,
    TOK_SPEEDS = 270,
    TOK_USB = 271,
    TOK_PRODUCT = 272,
    TOK_VENDOR = 273,
    TOK_CLASS = 274,
    TOK_SUBCLASS = 275,
    TOK_PROTOCOL = 276,
    TOK_DISK = 277,
    TOK_PTPIP = 278,
    TOK_DEVICE_TYPE = 279,
    TOK_DRIVER_STATUS = 280,
    TOK_OPERATIONS = 281,
    TOK_FILE_OPERATIONS = 282,
    TOK_FOLDER_OPERATIONS = 283,
    TOK_DRIVER_OPTIONS = 284,
    TOK_OPTION = 285,
    VAL_FLAG = 286
  };
#endif

/* Value type.  */

/* Location type.  */
#if ! defined YYLTYPE && ! defined YYLTYPE_IS_DECLARED
typedef struct YYLTYPE YYLTYPE;
struct YYLTYPE
{
  int first_line;
  int first_column;
  int last_line;
  int last_column;
};
# define YYLTYPE_IS_DECLARED 1
# define YYLTYPE_IS_TRIVIAL 1
#endif


extern YYSTYPE yylval;
extern YYLTYPE yylloc;
int yyparse (char const *file_name, CameraAbilitiesList *al);

#endif /* !YY_YY_DDB_TXT_TAB_H_INCLUDED  */
