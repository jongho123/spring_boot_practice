// Create a 'datalist" and "close" button and append it to each list item

$.get('/all').done(function(data) {
    for (var i = 0; i < data.length; i++) {
        var li = $("<li></li>");
        li.append($("<text></text>").text(data[i].name));
        li.append($("<span></span>").text("\u00D7").addClass("close"));
        $('ul').append(li);
    }

    // Click on a close button to hide the current list item
    var close = $("span.close");
    close.click(function() {
        var target = $($(this).parent()).clone().children().remove().end().text();
        $.get('/del', {name: target}).done(function(data) {
            console.log(data);
        })
        $(this).parent().css("display","none");
    });
});

// Add a "checked" symbol when clicking on a list item
var list = $('ul');
list.click(function(ev) {
    if (ev.target.tagName === 'LI') {
        ev.target.classList.toggle('checked');
    }
});

// Create a new list item when clicking on the "Add" button
function newElement() {
  var inputValue = $('#myInput');
  var li = $('<li></li>').text(inputValue.val());

  if (inputValue.val() === '') {
    alert("You must write something!");
  } else {
    $('#myUL').append(li);
  }

  $.get('/add', {name: inputValue.val()}).done(function(data) {
    console.log(data);
  });

  inputValue.val('');

  var span = $("<span></span>").text("\u00D7").addClass("close");
  li.append(span);
  span.click(function() {
    console.log($($(this).parent()).clone().children().remove().end().text());
    $(this).parent().css("display","none");
  });
}