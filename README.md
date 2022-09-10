# DPatlantis
This project is an application of a dynamic programming problem.

Problem Description: Atlantis Discovered
You’ve gone to sleep one night, and you find yourself dreaming about algorithms.
In your dream, you have become Aquaman, king of the lost city of Atlantis. But you sense
a disturbance in the waters. The humans have finally found Atlantis! You notice that they have
already begun claiming the land as theirs, and they’ve been destroying all the farms, which means
your people will no longer have access to food!
You have never encountered an enemy as fierce and powerful as them – they will stop at nothing
to gain control of the land. You have come to realize that no matter what, your people will lose all
of the land in the coming days. However, for whatever time remains, you would like to maximize
the livelihood of your community.
The city is divided up into N sections. Initially, you control all N sections. The city is long
and thus the sections can be represented as N squares on a line as depicted in Figure 1. In total,
you collect pi food from each section i, each day.
The humans will eventually conquer the entire city; thus, your objective is to maximize the
amount of food you collect before all the sections are overtaken.
At the beginning of each day, you can build a stick wall between two neighboring sections you
control. Subsequently, the humans observe the position of the wall and choose to overtake the
remaining city either from east or west – conquering all the sections before the wall. At the end of
the day, you count the total amount of food you collected from the side of the wall that remained
under your control, and the wall is destroyed. The same process is repeated every day until the
entire city is under human control.
You should be particularly careful when choosing the location of the wall. It’s known that the
humans can swim over the city, find the more bountiful half, and overtake it from the direction that
minimizes the amount of food your people collect in the long run. That is, the humans will attack
in a way that minimizes the amount of food your people collect (after you’ve chosen a location for
Programming Assignment #3: May 4, 2022, 11:59pm 2
the wall) in the CURRENT AND ALL FUTURE DAYS.
Figure 1: If the humans attack from the west, sections 5 and 6 will remain under your control and
the total food for the current day will be p5 +p6. If humans attack from the east, sections 1,2,3 and
4 will remain under your control and the total food for the current day will be p1 + p2 + p3 + p4.
Example: Consider N = 6 sections and p1 = 3, p2 = 2, p3 = 4, p4 = 2, p5 = 6, p6 = 8. The
best option for you is to build a wall between sections 4 and 5. The humans attack from east and
conquer sections 5 and 6 and that allows you to collect 11 food (from sections 1, 2, 3 and 4) by the
end of the day. At the beginning of the next day you build a wall between the sections 2 and 3.
The humans overtake from east and conquer sections 3 and 4 allowing you to collect 5 food (from
section 1 and 2) by the end of the day. At the beginning of the third day, you build a wall between
1 and 2. The humans overtake from west and conquer section 1 allowing you to collect 2 food from
section 2. There are no more neighbor sections for you to build a wall thus Atlantis has fallen with
total amount of food collected equal to 18.
Instructions
Implement a dynamic programming algorithm to find the maximum amount of food to be
obtained given an array of sections.
