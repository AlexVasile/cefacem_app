// Voting ajax request
$('.vote').click(function() {
	var post_id = $(this).attr("id").split("_")[1];
	var vote_type = $(this).attr("id").split("_")[0];
	$.ajax({
		type: "POST",
		url: "/cefacem/vote/ajax",
		data: {id: post_id, vote_type: vote_type},
		dataType: "json",
		success: function(data) {
			if (data.success === "yes") {
				$("#score_" + post_id).text(data.score);
			}
		},	
	});
	return false;
});