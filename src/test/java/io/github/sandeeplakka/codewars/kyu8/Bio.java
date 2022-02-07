package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

DNA to RNA Conversion

Description:
Deoxyribonucleic acid, DNA is the primary information storage molecule in biological systems.
It is composed of four nucleic acid bases Guanine ('G'), Cytosine ('C'), Adenine ('A'), and Thymine ('T').
Ribonucleic acid, RNA, is the primary messenger molecule in cells.
RNA differs slightly from DNA its chemical structure and contains no Thymine.
In RNA Thymine is replaced by another nucleic acid Uracil ('U').
Create a function which translates a given DNA string into RNA.

For example:    "GCAT"  =>  "GCAU"

The input string can be of arbitrary length - in particular,
it may be empty. All input is guaranteed to be valid,
i.e. each input string will only ever consist of 'G', 'C', 'A' and/or 'T'.

Categories : Fundamentals, Strings
 */
public class Bio {

    @Test
    public void testDna() {
        assertEquals("UUUU", dnaToRna("TTTT"));
    }

    @Test
    public void testDna2() {
        assertEquals("GCAU", dnaToRna("GCAT"));
    }

    @Test
    public void testDna3() {
        assertEquals("GACCGCCGCC", dnaToRna("GACCGCCGCC"));
    }

    @Test
    public void testDna4() {
        assertEquals("GAUUCCACCGACUUCCCAAGUACCGGAAGCGCGACCAACUCGCACAGC",
                dnaToRna("GATTCCACCGACTTCCCAAGTACCGGAAGCGCGACCAACTCGCACAGC"));
    }

    @Test
    public void testDna5() {
        assertEquals("CACGACAUACGGAGCAGCGCACGGUUAGUACAGCUGUCGGUGAACUCCAUGACA",
                dnaToRna("CACGACATACGGAGCAGCGCACGGTTAGTACAGCTGTCGGTGAACTCCATGACA"));
    }

    @Test
    public void testDna6() {
        assertEquals("CACGACAUACGGAGCAGCGCACGGUUAGUACAGCUGUCGGUGAACUCCAUGACA",
                dnaToRna("CACGACATACGGAGCAGCGCACGGTTAGTACAGCTGTCGGTGAACTCCATGACA"));
    }

    @Test
    public void testDna7() {
        assertEquals("AACCCUGUCCACCAGUAACGUAGGCCGACGGGAAAAAUAAACGAUCUGUCAAUG",
                dnaToRna("AACCCTGTCCACCAGTAACGTAGGCCGACGGGAAAAATAAACGATCTGTCAATG"));
    }

    @Test
    public void testDna8() {
        assertEquals("GAAGCUUAUCCGUUCCUGAAGGCUGUGGCAUCCUCUAAAUCAGA" +
                "CUUGGCUACGCCGUUAGCCGAGGGCUUAGCGUUGAGUGUCAUUAUAUACGCGGCCUGCG" +
                "ACCUGGCCACACAAUGCCCUCGAAAAUUUUUCUUUCGGUUAUACGAGUUGCGAAACCUUU" +
                "CGCGCGUAGACGAAGAAUUUGAAGUGGCCUACACCGUUUGGAAAGCCGUUCUCAUUAGAA" +
                "UGGUACCGACUACUCGGCUCGGAGUCAUUGUAUAGGGAGAGUGUCGUAUCAACAUCACACA" +
                "CUUUUAGCAUUUAAGGUCCAUGGCCGUUGACAGGUACCGA", dnaToRna("GAAGCTTATCCGTT" +
                "CCTGAAGGCTGTGGCATCCTCTAAATCAGACTTGGCTACGCCGTTAGCCGAGGGCTTAGCGT" +
                "TGAGTGTCATTATATACGCGGCCTGCGACCTGGCCACACAATGCCCTCGAAAATTTTTCTTTC" +
                "GGTTATACGAGTTGCGAAACCTTTCGCGCGTAGACGAAGAATTTGAAGTGGCCTACACCGTT" +
                "TGGAAAGCCGTTCTCATTAGAATGGTACCGACTACTCGGCTCGGAGTCATTGTATAGGGAGAG" +
                "TGTCGTATCAACATCACACACTTTTAGCATTTAAGGTCCATGGCCGTTGACAGGTACCGA"));
    }

    //had to commit it to have record of completion, this is no brainer as with most of kyu8/7s
    public String dnaToRna(String dna) {
        return dna.replaceAll("T", "U");  // Do your magic!
    }
}