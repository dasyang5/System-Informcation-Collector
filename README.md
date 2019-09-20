# System-Informcation-Collector
Collect operating system information by Java.

Centos
libsigar-amd64-linux.so 拷贝到/usr/lib64/下面
授权
sudo chmod 744 /usr/lib64/libsigar-amd64-linux.so
chmod a+x /usr/lib64/libsigar-amd64-linux.so


<table class="confluenceTable" style="border:1px solid #C0C0C0;border-collapse:collapse;clear:left;font-size:13px;color:rgb(0,0,0);line-height:17px;font-family:Arial, Helvetica, FreeSans, sans-serif;"><tbody><tr style="font-size:10pt;line-height:13pt;"><th class="confluenceTh" style="border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;font-size:10pt;vertical-align:top;line-height:13pt;">
File</th>
<th class="confluenceTh" style="border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;font-size:10pt;vertical-align:top;line-height:13pt;">
Language</th>
<th class="confluenceTh" style="border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;font-size:10pt;vertical-align:top;line-height:13pt;">
Description</th>
<th class="confluenceTh" style="border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;font-size:10pt;vertical-align:top;line-height:13pt;">
Required</th>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
sigar.jar</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Java</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Java API</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Yes (for Java only)</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
log4j.jar</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Java</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Java logging API</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
No</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-x86-linux.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Linux AMD/Intel 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-amd64-linux.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Linux AMD/Intel 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-ppc-linux.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Linux PowerPC 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-ppc64-linux.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Linux PowerPC 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-ia64-linux.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Linux Itanium 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-s390x-linux.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Linux zSeries 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
sigar-x86-winnt.dll</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Windows AMD/Intel 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
sigar-amd64-winnt.dll</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Windows AMD/Intel 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-ppc-aix-5.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
AIX PowerPC 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-ppc64-aix-5.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
AIX PowerPC 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-pa-hpux-11.sl</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
HP-UX PA-RISC 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-ia64-hpux-11.sl</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
HP-UX Itanium 64-bt</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-sparc-solaris.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Solaris Sparc 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-sparc64-solaris.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Solaris Sparc 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-x86-solaris.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Solaris AMD/Intel 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-amd64-solaris.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Solaris AMD/Intel 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-universal-macosx.dylib</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Mac OS X PowerPC/Intel 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-universal64-macosx.dylib</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
Mac OS X PowerPC/Intel 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-x86-freebsd-5.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
FreeBSD 5.x AMD/Intel 32-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-x86-freebsd-6.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
FreeBSD 6.x AMD/Intel 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr><tr style="font-size:10pt;line-height:13pt;"><td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
libsigar-amd64-freebsd-6.so</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
C</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
FreeBSD 6.x AMD/Intel 64-bit</td>
<td class="confluenceTd" style="font-size:10pt;border:1px solid rgb(221,221,221);border-collapse:collapse;min-width:.6em;vertical-align:top;line-height:13pt;">
*</td>
</tr></tbody></table>