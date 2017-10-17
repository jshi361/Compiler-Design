The objective of this project is to emit instructions for ⟨cond⟩, ⟨switch⟩, ⟨while loop⟩, ⟨do loop⟩, ⟨for loop⟩. Assume that all variable identifiers are globally scoped throughout the program. 

Use the following additional instructions: 

ifF goto label	pop the top of stack; if its value is false, goto label
goto label	unconditionally goto label

All labels must be positive integers. Integer labels need not appear in sequential or even increasing order in instruction streams, but the same label must not appear at two or more locations in any instruction streams. 

Description of Intermediate-Code Operational Semantics 

The following intermediate-code operational semantics is to be used for compilation.
conditionals
if (B) S

      code to evaluate B
      ifF goto Out
      code for S
Out:

if (B) S1 else S2

      code to evaluate B
      ifF goto Else
      code for S1
      goto Out
Else: code for S2
Out:
switch
switch (E) {case_list}
The exclusive-case semantics is to be implemented. Let L1, …, Ln be the labels in case_list, S1, …, Sn the corresponding statement lists, Sd the statement list in the default case.
      code to evaluate E
      pop x
      push x
      push L1
      eq
      ifF goto A2
      code for S1
      goto Out
A2:
      push x
      push L2
      eq
      ifF goto A3
      code for S2
      goto Out
         ...
An:
      push x
      push Ln
      eq
      ifF goto Ad
      code for Sn
      goto Out
Ad:
      code for Sd
Out:
You may assume that the labels L1, …, Ln are all distinct and the default case appears at most once. Note that the default case may appear in any position, but this does not affect the exclusive-case semantics. Note also that the default case may be absent. The above operational semantics has a different control flow from the one described in Course Notes #7, and should be easier to implement. (Of course they have the same overall effect of execution.) 

while-loop
while (B) S

Loop: code to evaluate B
      ifF goto Out
      code for S
      goto Loop
Out:
do-loop
do S while (B)

Loop: code for S
      code to evaluate B
      ifF goto Out
      goto Loop
Out:
for-loop
for (assign1; B; assign2) S

      code for assign1
Loop: code to evaluate B
      ifF goto Out
      code for S
      code for assign2
      goto Loop
Out:
