tell application "iTunes"
	if exists playlist <PLAYLIST> then
		set playlist001 to user playlist <PLAYLIST>
	else
		set playlist001 to (make new user playlist with properties {name:<PLAYLIST>, shuffle:false, song repeat:one})
	end if
	
	set track001 to (add POSIX file <PATH>)
	
	delay 1
	duplicate track001 to playlist001
end tell