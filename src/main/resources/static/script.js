$('.newPost button[data-func]').click(function(){
    document.execCommand( $(this).data('func'), false 	);
  });
    $('button[data-func="clear"]').click(function(){
      $('.editor').html('');
    });
