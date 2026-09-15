class Solution:
    def longestPalindrome(self, s: str) -> str:

        maxLen = 0
        res = ""

        for i in range(len(s)):
            #mark i as center and expand outwards brp

            #odd palindrom length case, we keep i at center and start at both
            #pointers at i and expand so length will always be odd
            l,r = i,i

            while l>=0 and r<len(s) and s[l] == s[r]:
                curr_len = r-l+1
                if curr_len > maxLen:
                    maxLen = curr_len
                    res = s[l:r+1]
                l-=1
                r+=1
                
            
            #even case, where we start with i and j+1 i-> a, j-> b in ab
            #here i the element is in left not center

            l,r = i,i+1
            #Same old stuff
            while l>=0 and r<len(s) and s[l] == s[r]:
                curr_len = r-l+1
                if curr_len > maxLen:
                    maxLen = curr_len
                    res = s[l:r+1]
                l-=1
                r+=1


        return res
        